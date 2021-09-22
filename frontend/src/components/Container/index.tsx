import { LayoutContainer } from './styles';

type ContainerProps = {
  children: React.ReactNode;
};

const Container: React.FC<ContainerProps> = ({ children }) => {
  return <LayoutContainer>{children}</LayoutContainer>;
};

export { Container };
