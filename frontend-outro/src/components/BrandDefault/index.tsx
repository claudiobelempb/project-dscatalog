import Imagem from 'next/image';
import Link from 'next/link';
import { BrandContainer } from './styles';

type BrandProps = {
  title?: string;
  src?: string;
  link?: string;
};

const BrandDefault: React.FC<BrandProps> = ({
  title = 'brand',
  src = '',
  link = '/',
}) => {
  return (
    <BrandContainer>
      <Link href={link}>
        <a>
          <h1>
            {!!src && (
              <Imagem src={src} alt="brand" height={'33'} width={'125'} />
            )}
            {!src && title}
          </h1>
        </a>
      </Link>
    </BrandContainer>
  );
};

export { BrandDefault };
