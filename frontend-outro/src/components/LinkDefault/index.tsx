import Link from 'next/link';
import { LinkContainer } from './styles';

type LinkProps = {
  title: string;
  href: string;
  target?: boolean;
};

const LinkDefault: React.FC<LinkProps> = ({ title, href, target }) => {
  const tab = target ? '_blank' : '_self';
  return (
    <Link href={href} passHref>
      <LinkContainer target={tab}>{title}</LinkContainer>
    </Link>
  );
};

export { LinkDefault };
