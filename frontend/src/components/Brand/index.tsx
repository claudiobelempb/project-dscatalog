import Imagem from 'next/image';
import Link from 'next/link';
import { BrandContainer } from './styles';

type BrandProps = {
  title?: string;
  src?: string;
  link?: string;
};

const Brand: React.FC<BrandProps> = ({
  title = 'brand',
  src = '',
  link = '/',
}) => {
  return (
    <Link href={link}>
      <a>
        <BrandContainer>
          {!!src && (
            <Imagem src={src} alt="brand" height={'33'} width={'125'} />
          )}
          {!src && title}
        </BrandContainer>
      </a>
    </Link>
  );
};

export { Brand };
